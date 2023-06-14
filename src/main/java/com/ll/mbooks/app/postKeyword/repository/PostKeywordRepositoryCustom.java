package com.ll.mbooks.app.postKeyword.repository;

import com.ll.mbooks.app.postKeyword.entity.PostKeyword;

import java.util.List;

public interface PostKeywordRepositoryCustom {
    List<PostKeyword> getQslAllByAuthorId(Long authorId);
}
