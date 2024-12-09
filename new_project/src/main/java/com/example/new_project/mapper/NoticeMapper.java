package com.example.new_project.mapper;

import com.example.new_project.entity.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
	List<Notice> selectNoticeList() throws Exception;
	
	void insertNotice(Notice notice) throws Exception;

	Notice selectNoticeDetail(int noticeIdx) throws Exception;

	void updateHitCount(int noticeIdx) throws Exception;
	
	void updateNotice(Notice notice) throws Exception;
	
	void deleteNotice(int noticeIdx) throws Exception;
}
