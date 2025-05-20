package com.teamplay.choimemo.memo.service;

import com.teamplay.choimemo.memo.domain.Memo;
import com.teamplay.choimemo.memo.dto.MemoIdRequest;
import com.teamplay.choimemo.memo.dto.MemoRequest;
import com.teamplay.choimemo.memo.dto.MemoResponse;
import com.teamplay.choimemo.memo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 기능 명세
 * service 계층으로서 CRUD 기능 수행 및
 */

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;

    @Transactional
    public MemoResponse createMemo(MemoRequest memoRequest) {
        Memo memo = new Memo(memoRequest.title(), memoRequest.content()); // 생성자 사용
        Memo saved = memoRepository.save(memo); // DB에 저장
        return MemoResponse.from(saved); // 응답 DTO로 변환
    }

    @Transactional(readOnly = true)
    public MemoResponse readMemo(MemoIdRequest memoIdRequest) {
        Memo memo = memoRepository.findById(memoIdRequest.id()).get();
        return MemoResponse.from(memo);
    }

    @Transactional
    public MemoResponse updateMemo(Long id,MemoRequest memoRequest) {
        Memo memo = memoRepository.findById(id).get();
        memo.update(memoRequest.title(), memoRequest.content());
        return MemoResponse.from(memo);
    }

    @Transactional
    public void deleteMemo(MemoIdRequest memoIdRequest) {
        Memo memo = memoRepository.findById(memoIdRequest.id()).get();
        memoRepository.delete(memo);
    }

    @Transactional(readOnly = true)
    public List<MemoResponse> getMemoList() {
        return memoRepository.findAll().stream()
                .map(memo -> MemoResponse.from(memo))
                .toList(); // Java 16+ or use .collect(Collectors.toList()) for lower versions
    }
}
