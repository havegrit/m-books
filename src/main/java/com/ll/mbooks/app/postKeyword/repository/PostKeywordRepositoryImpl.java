package com.ll.mbooks.app.postKeyword.repository;

import com.ll.mbooks.app.postKeyword.entity.PostKeyword;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static com.ll.mbooks.app.postKeyword.entity.QPostKeyword.postKeyword;
import static com.ll.mbooks.app.postTag.entity.QPostTag.postTag;

@RequiredArgsConstructor
public class PostKeywordRepositoryImpl implements PostKeywordRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<PostKeyword> getQslAllByAuthorId(Long authorId) {
        List<Tuple> fetch = jpaQueryFactory
                .select(postKeyword, postTag.count())
                .from(postKeyword)
                .innerJoin(postTag)
                .on(postKeyword.eq(postTag.postKeyword))
                .where(postTag.member.id.eq(authorId))
                .orderBy(postTag.post.id.desc())
                .groupBy(postKeyword.id)
                .fetch();

        return fetch.stream().
                map(tuple -> {
                    PostKeyword _postKeyword = tuple.get(postKeyword);
                    Long postTagsCount = tuple.get(postTag.count());

                    _postKeyword.getExtra().put("postTagsCount", postTagsCount);

                    return _postKeyword;
                })
                .collect(Collectors.toList());
    }
}
