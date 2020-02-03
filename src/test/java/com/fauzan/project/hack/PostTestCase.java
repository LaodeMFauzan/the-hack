package com.fauzan.project.hack;

import com.fauzan.project.hack.dao.PostDataAccessService;
import lombok.RequiredArgsConstructor;
import org.mockito.Mockito;
import org.springframework.stereotype.Service;

/**
 * Created by Intellij IDEA
 * User : fauzan
 * Date : 03/02/20
 */
@Service
@RequiredArgsConstructor
public class PostTestCase {

    private final PostDataAccessService postDataAccessService = Mockito.mock(PostDataAccessService.class);

}
