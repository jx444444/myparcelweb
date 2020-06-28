package com.c.myParcel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MultipartFileConvert {
	public List<File> convert(List<MultipartFile> mfile,String index,Base64Encoding encoder) throws IOException {
		List<File> filelist = new ArrayList<File>();
		for(int i=0 ; i<mfile.size() ; i++) {
			System.out.println(mfile.get(i).getOriginalFilename());
			
			int pos = mfile.get(i).getOriginalFilename().lastIndexOf( "." );
			String filename = encoder.Base64StringEncode(index+":미리보기"+(i+1)+":"+(i))+"."+mfile.get(i).getOriginalFilename().substring(pos+1);
			
			File file = new File(filename);
			mfile.get(i).transferTo(file);
			filelist.add(file);
		}
		System.out.println(filelist.toString());
		return filelist;
		
	}
}
