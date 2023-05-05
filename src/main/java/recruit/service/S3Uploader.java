package recruit.service;

import java.io.IOException;
import java.util.UUID;

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
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class S3Uploader {
	
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

}
