package com.example.new_project.service;

import com.example.new_project.entity.Notice;

import java.util.List;

public interface NoticeService {

	List<Notice> selectNoticeList() throws Exception;

	void insertNotice(Notice notice) throws Exception;

	Notice selectNoticeDetail(int noticeIdx) throws Exception;

	void updateHitCount(int noticeIdx) throws Exception;

	void updateNotice(Notice notice) throws Exception;

	void deleteNotice(int noticeIdx) throws Exception;
}
