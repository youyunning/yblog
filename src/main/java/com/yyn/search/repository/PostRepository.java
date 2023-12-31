package com.yyn.search.repository;

import com.yyn.search.model.PostDocment;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends ElasticsearchRepository<PostDocment, Long> {

    // 符合jpa命名规范的接口


}
