## 상황

- 연관관계인 값이 없는 경우 nullpoint

OneToMany 관계를 2개 이상 함께 조회해야 하는 경우

```sql

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "community_board")
@ToString
public class CommunityBoardEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    @Comment("게시판시퀀스")
    private Long boardId;
    
    /// .... 
    
    @BatchSize(size = 100)
    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CommunityBoardReplyEntity> replies = new HashSet<>();

    @BatchSize(size = 100)
    @OneToMany(mappedBy = "boardId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<BoardFileEntity> files = new HashSet<>();

```

```sql
@Query("SELECT DISTINCT c FROM CommunityBoardEntity c JOIN FETCH c.files cf JOIN FETCH c.replies cr WHERE c.boardId = :boardId")
    CommunityBoardEntity findQuestionBoardById(Long boardId);
```

```sql
[Hibernate] 
    /* SELECT
        DISTINCT c 
    FROM
        CommunityBoardEntity c 
    JOIN
        FETCH c.files cf 
    JOIN
        FETCH c.replies cr 
    WHERE
        c.boardId = :boardId */ select
            distinct c1_0.board_id,
            c1_0.board_category,
            c1_0.board_status,
            c1_0.board_type,
            c1_0.board_content,
            f1_0.board_id,
            f1_0.file_seq,
            f1_0.file_name,
            f1_0.file_path,
            f1_0.file_size,
            f1_0.orig_file_name,
            c1_0.input_date,
            c1_0.input_user_id,
            r1_0.boardId,
            r1_0.reply_seq,
            r1_0.input_date,
            r1_0.input_user_id,
            r1_0.reply_content,
            r1_0.update_date,
            c1_0.board_title,
            c1_0.update_date 
        from
            community_board c1_0 
        join
            board_file f1_0 
                on c1_0.board_id=f1_0.board_id 
        join
            board_reply r1_0 
                on c1_0.board_id=r1_0.boardId 
        where
            c1_0.board_id=?
```

```sql
2025-01-22T22:51:22,236 d2cf10c2-819e-4051-b3c5-535562c3d81f ERROR[GET][/api/community/qna/12] [0:0:0:0:0:0:0:1][http-nio-8080-exec-1]c.b.f.f.ResponseWrapperFilter:Request processing failed: java.lang.NullPointerException: Cannot invoke "com.sample.infra.persistence.entity.CommunityBoardEntity.toDto()" because "boards" is null
jakarta.servlet.ServletException: Request processing failed: java.lang.NullPointerException: Cannot invoke "com.sample.infra.persistence.entity.CommunityBoardEntity.toDto()" because "boards" is null

```

### 결론

- oneToMany  연관관계 Join table에서 실제로 값이 없어서 실패
- LEFT JOIN FETCH 로 변환 → join 될 값이 null여도, board 가 있을 경우 값 반환

```
    @Query("SELECT c FROM CommunityBoardEntity c LEFT JOIN FETCH c.files cf LEFT JOIN FETCH c.replies cr WHERE c.boardId = :boardId")
    CommunityBoardEntity findQuestionBoardById(Long boardId);
```