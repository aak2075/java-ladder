# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 뷰
- [ ] 입력
  - [ ] 사람 이름을 입력 받는다
    - [ ] 사람 이름 요구한다
    - [ ] 사람들은 ','로 구분된다
    - [ ] 빈값은 허용되지 않는다
    - [ ] 입력값의 공백을 제거한다
  - [ ] 높이를 입력 받는다
    - [ ] 높이를 요구한다
    - [ ] 양의 정수만 허용된다
    - [ ] 빈값은 허용되지 않는다
- [ ] 출력
  - [ ] 실행 결과 문구를 출력한다
  - [ ] 이름들을 출력한다
  - [ ] 사다리를 출력한다
    - [ ] 사다리의 폭은 사람 이름의 최대길이에 따른다
  
## 비지니스 로직
- [x] 사다리
  - [x] 사다리는 층들을 갖는다
- [x] 층
  - [x] 사람 총 수보다 한개 적은 다리를 갖는다
  - [x] 다리는 랜덤으로 연결된다
  - [x] 다리는 연속해서 연결되지 않는다
