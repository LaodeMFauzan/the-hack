//package com.fauzan.project.hack.dao;
//
//import com.fauzan.project.hack.model.Post;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
///**
// * Created by Intellij IDEA
// * User : fauzan
// * Date : 27/01/20
// */
//@Repository("fakeDao")
//public class FakePostDataAccessService implements PostDao {
//
//    private static List<Post> postDB = new ArrayList<>();
//
//    @Override
//    public int insertPerson(UUID id, Post post) {
//        postDB.add(new Post(id, post.getName()));
//        return 1;
//    }
//
//    @Override
//    public List<Post> selectAllPeople() {
//        return postDB;
//    }
//
//    @Override
//    public Optional<Post> selectPersonById(UUID id) {
//        return postDB.stream().
//                filter(person -> person.getId().equals(id)).
//                findFirst();
//    }
//
//    @Override
//    public int deletePerson(UUID id) {
//        Optional<Post> person = selectPersonById(id);
//        if (person.isEmpty()){
//            return 0;
//        }
//        postDB.remove(person.get());
//        return 1;
//    }
//
//    @Override
//    public int updatePerson(UUID id, Post post) {
//        return selectPersonById(id)
//                .map(p -> {
//                    int indexPersonToDelete = postDB.indexOf(p);
//                    if (indexPersonToDelete >= 0){
//                        p.setName(post.getName());
//                        return 1;
//                    }
//                    return 0;
//                })
//                .orElse(0);
//    }
//}
