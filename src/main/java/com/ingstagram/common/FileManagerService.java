package com.ingstagram.common;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManagerService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//실제 업로드가 된 이미지가 저장될 경로(서버)
	public static final String FILE_UPLOAD_PATH = "D:\\이연수\\7_Project\\ingstagram\\workspace\\images/";
	
	//input: userLoginId, file(이미지)  output: web imagePath
	public String saveFile(String loginId, MultipartFile file) {
		// 폴더 생성
		String directoryName = loginId + "_" + System.currentTimeMillis();
		String filePath = FILE_UPLOAD_PATH + directoryName;
		
		File directory = new File(filePath);
		if(directory.mkdir() == false) {
			//폴더 생성 실패시 이미지 경로 null로 리턴
			return null;
		}
		
		// 파일 업로드 : byte 단위로 업로드
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(filePath + "/" + file.getOriginalFilename());
			Files.write(path, bytes); // 파일 업로드
		} catch(IOException e) {
			e.printStackTrace();
			return null; // 이미지 업로드 실패시 null 리턴
		}
		return "/images/" + directoryName + "/" + file.getOriginalFilename();
	}
	
	// 파일 삭제 메소드
	// input : imagePath
	// output : void
	public void deleteFile(String imagePath) {
		Path path = Paths.get(FILE_UPLOAD_PATH + imagePath.replace("/images/", ""));
		if(Files.exists(path)) {
			try {
				Files.delete(path);
			} catch(IOException e) {
				logger.info("###[FileManagerService 이미지 삭제 실패] imagePath:{}",imagePath);
			}
			
			//디렉토리(폴더) 삭제
			path = path.getParent();
			if(Files.exists(path)) {
				try {
					Files.delete(path);
				} catch (IOException e) {
					logger.info("###[FileManagerService 이미지 폴더 삭제 실패] imagePath:{}", imagePath);
				}
			}
		}
	}
}
