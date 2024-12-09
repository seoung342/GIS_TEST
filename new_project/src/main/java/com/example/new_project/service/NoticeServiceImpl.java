package com.example.new_project.service;

import com.example.new_project.entity.Notice;
import com.example.new_project.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

	private final NoticeMapper noticeMapper;

	@Override
	public List<Notice> selectNoticeList() throws Exception {
		return noticeMapper.selectNoticeList();
	}

	@Override
	public void insertNotice(Notice notice) throws Exception {
		noticeMapper.insertNotice(notice);
	}

	@Override
	public Notice selectNoticeDetail(int noticeIdx) throws Exception {
		Notice notice = noticeMapper.selectNoticeDetail(noticeIdx);
		noticeMapper.updateHitCount(noticeIdx);
		return notice;
	}

	@Override
	public void updateHitCount(int noticeIdx) throws Exception {
		noticeMapper.updateHitCount(noticeIdx);
	}

	@Override
	public void updateNotice(Notice notice) throws Exception {
		noticeMapper.updateNotice(notice);
	}

	@Override
	public void deleteNotice(int noticeIdx) throws Exception {
		noticeMapper.deleteNotice(noticeIdx);
	}
}

