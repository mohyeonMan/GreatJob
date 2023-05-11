package recruit.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class S3Manager {
	
	public AmazonS3 amazonS3;
	@Value("${cloud.aws.s3.bucket}")
	private String bucket;
	
	public String upload(MultipartFile multipartFile) throws IOException {
		String fileName = UUID.randomUUID() + "_" + multipartFile.getOriginalFilename();
		
		ObjectMetadata objMeta = new ObjectMetadata();
		objMeta.setContentLength(multipartFile.getInputStream().available());
		objMeta.setContentType(multipartFile.getContentType());
		
		amazonS3.putObject(new PutObjectRequest(bucket, fileName, multipartFile.getInputStream(), objMeta));
		
		return amazonS3.getUrl(bucket, fileName).toString();
	}
	
	public void delete(String imageUrl) {
			String fileName = imageUrl.substring("https://greatjobimage.s3.amazonaws.com/".length());
			try {
				fileName = URLDecoder.decode(fileName, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {				
			amazonS3.deleteObject(new DeleteObjectRequest(bucket, fileName));
			}
		
	}
	
	public String UploadGetUrl(List<MultipartFile> images) {
		String imageUrls = "";
				System.out.println(images.size());
		for(int i = 0;i<images.size();i++) {
			try {
				String imageUrl = upload(images.get(i));
				imageUrls += imageUrl;
				
				if(i != images.size()-1) {
					imageUrls+=",";
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return imageUrls == ""? null:imageUrls;
		
	}
	
	public void deleteS3Image(String imageUrlString) {
		String[] imageUrlArray= imageUrlString.split(",");
		for (String imageUrl : imageUrlArray) {
			delete(imageUrl);
		}
	}

}
