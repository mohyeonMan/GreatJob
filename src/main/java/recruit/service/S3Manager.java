package recruit.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.tomcat.util.buf.Utf8Decoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class S3Manager {
	
	private final AmazonS3 amazonS3;
	
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
			System.out.println("target filName ==== "+fileName);
			amazonS3.deleteObject(new DeleteObjectRequest(bucket, fileName));
			}
		
	}

}
