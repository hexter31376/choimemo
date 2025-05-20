간단한 메모 API 서비스 구축  
===
프로젝트 요약
---
json type으로 데이터를 주고받는 RESTFUL 메모 API 서비스를 간단하게 구축해 보았습니다  
CRUD 기능을 활용하여 간단하게 구축하였으며  
http 프로토콜을 활용한 테이터 송수신이 가능합니다  
  
작성한 시간, 수정한 시간을 타임스탬프로 유지하여 기록합니다.
  
메소드 요약
---

| 기능 | 메소드 | URL |
| --- | --- | --- |
| 전체 메모 리스트 조회 | GET | /memos |
| 메모 작성 | POST | /memos |
| 메모 읽기 | GET | /memos/{id} |
| 메모 수정 | PUT | /memos/{id} |
| 메모 삭제 | DELETE | /memos/{id} |
  
Request
---

```json
{
  "title": "예시 제목"
  "content": "예시 글 컨텐츠"
}
```

Response
---
```json
{
    "id": 1,
    "title": "예시 글",
    "content": "첫번째 글입니다 여기에는 데이터가 담겨있지요",
    "createdAt": "2025-05-20T15:42:56.35953",
    "updatedAt": "2025-05-20T15:42:56.35953"
}
```
