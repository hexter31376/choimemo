package com.teamplay.choimemo.memo.controller;

import com.teamplay.choimemo.memo.dto.MemoIdRequest;
import com.teamplay.choimemo.memo.dto.MemoRequest;
import com.teamplay.choimemo.memo.dto.MemoResponse;
import com.teamplay.choimemo.memo.service.MemoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memos")
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;

    @GetMapping
    public List<MemoResponse> findAll() {
        return memoService.getMemoList();
    }

    @PostMapping
    public MemoResponse create(@RequestBody @Valid MemoRequest request) {
        return memoService.createMemo(request);
    }

    @GetMapping("/{id}")
    public MemoResponse findById(@PathVariable Long id) {
        return memoService.readMemo(new MemoIdRequest(id));
    }

    @PutMapping("/{id}")
    public MemoResponse update(@PathVariable Long id, @RequestBody @Valid MemoRequest request) {
        return memoService.updateMemo(id ,new MemoRequest(request.title(), request.content()));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        memoService.deleteMemo(new MemoIdRequest(id));
    }
}
