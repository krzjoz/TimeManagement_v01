package com.jk.timemrgapp.data;

import com.jk.timemrgapp.dto.entity.CategoryEntity;
import com.jk.timemrgapp.dto.entity.StatusEntity;
import com.jk.timemrgapp.dto.entity.TaskEntity;
import com.jk.timemrgapp.dto.entity.security.AuthorityEntity;
import com.jk.timemrgapp.dto.entity.security.UserEntity;
import com.jk.timemrgapp.dto.repository.CategoryRepository;
import com.jk.timemrgapp.dto.repository.StatusRepository;
import com.jk.timemrgapp.dto.repository.TaskRepository;
import com.jk.timemrgapp.dto.repository.security.AuthorityRepository;
import com.jk.timemrgapp.dto.repository.security.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final AuthorityRepository authorityRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final StatusRepository statusRepository;
    private final TaskRepository taskRepository;
    private final PasswordEncoder passwordEncoder;

    private void loadData() {
        AuthorityEntity userRole = authorityRepository.save(AuthorityEntity.builder().role("USER").build());
        AuthorityEntity adminRole = authorityRepository.save(AuthorityEntity.builder().role("ADMIN").build());

        //User
        UserEntity user = userRepository.save(UserEntity.builder()
                .username("user")
                .hashPass(passwordEncoder.encode("user"))
                .authority(userRole)
                .build());

        UserEntity user1 = userRepository.save(UserEntity.builder()
                .username("user1")
                .hashPass(passwordEncoder.encode("user1"))
                .authority(userRole)
                .build());

        UserEntity user2 = userRepository.save(UserEntity.builder()
                .username("user2")
                .hashPass(passwordEncoder.encode("user2"))
                .authority(userRole)
                .build());

        UserEntity admin = userRepository.save(UserEntity.builder()
                .username("admin")
                .hashPass(passwordEncoder.encode("admin"))
                .authority(adminRole)
                .build());

        //Category
        categoryRepository.save(CategoryEntity.builder()
                .categoryDesc("none")
                .build());

        CategoryEntity catWork = categoryRepository.save(CategoryEntity.builder()
                .categoryDesc("Work")
                .build());

        CategoryEntity catHome = categoryRepository.save(CategoryEntity.builder()
                .categoryDesc("Home")
                .build());

        CategoryEntity catStudy = categoryRepository.save(CategoryEntity.builder()
                .categoryDesc("Study")
                .build());

        CategoryEntity catFun = categoryRepository.save(CategoryEntity.builder()
                .categoryDesc("Fun")
                .build());

        CategoryEntity catOther = categoryRepository.save(CategoryEntity.builder()
                .categoryDesc("Other")
                .build());

        //Status
        statusRepository.save(StatusEntity.builder()
                .statusDesc("none")
                .build());

        StatusEntity stausPlanned = statusRepository.save(StatusEntity.builder()
                .statusDesc("Planned")
                .build());

        StatusEntity stausProgress = statusRepository.save(StatusEntity.builder()
                .statusDesc("In progress")
                .build());

        StatusEntity stausCompleted = statusRepository.save(StatusEntity.builder()
                .statusDesc("Completed")
                .build());

        StatusEntity stausCancelled = statusRepository.save(StatusEntity.builder()
                .statusDesc("Cancelled")
                .build());

        StatusEntity stausUpcomming = statusRepository.save(StatusEntity.builder()
                .statusDesc("Upcoming")
                .build());

        StatusEntity stausOverdue = statusRepository.save(StatusEntity.builder()
                .statusDesc("Overdue")
                .build());

        //Tasks
        taskRepository.save(TaskEntity.builder()
                .taskName("task 1")
                .taskDesc("description 1")
                .statusId(stausPlanned)
                .categoryId(catStudy)
                .taskFromDate(LocalDateTime.parse("2020-01-20T16:00"))
                .taskToDate(LocalDateTime.parse("2020-01-20T19:00"))
                .user(user)
                .build());

        taskRepository.save(TaskEntity.builder()
                .taskName("task 2")
                .taskDesc("description ssda asdas")
                .statusId(stausProgress)
                .categoryId(catWork)
                .taskFromDate(LocalDateTime.parse("2020-01-20T13:00"))
                .taskToDate(LocalDateTime.parse("2020-01-21T15:00"))
                .user(user)
                .build());

        taskRepository.save(TaskEntity.builder()
                .taskName("task 3")
                .taskDesc("description asassa")
                .statusId(stausUpcomming)
                .categoryId(catWork)
                .taskFromDate(LocalDateTime.parse("2020-01-21T14:00"))
                .taskToDate(LocalDateTime.parse("2020-01-21T16:00"))
                .user(user2)
                .build());

        taskRepository.save(TaskEntity.builder()
                .taskName("task 4")
                .taskDesc("description zzzaaq cxz")
                .statusId(stausPlanned)
                .categoryId(catHome)
                .taskFromDate(LocalDateTime.parse("2020-01-19T08:30"))
                .taskToDate(LocalDateTime.parse("2020-01-22T17:30"))
                .user(user)
                .build());

        taskRepository.save(TaskEntity.builder()
                .taskName("task 5")
                .taskDesc("description kjhgf hgfds yrteesd")
                .statusId(stausCompleted)
                .categoryId(catFun)
                .taskFromDate(LocalDateTime.parse("2020-01-20T12:15"))
                .taskToDate(LocalDateTime.parse("2020-01-21T14:45"))
                .user(user1)
                .build());

        taskRepository.save(TaskEntity.builder()
                .taskName("task 6")
                .taskDesc("description rdv thedg dfsd")
                .statusId(stausUpcomming)
                .categoryId(catWork)
                .taskFromDate(LocalDateTime.parse("2020-01-20T09:00"))
                .taskToDate(LocalDateTime.parse("2020-01-20T11:00"))
                .user(user1)
                .build());

        taskRepository.save(TaskEntity.builder()
                .taskName("task 7")
                .taskDesc("description 7")
                .statusId(stausPlanned)
                .categoryId(catHome)
                .taskFromDate(LocalDateTime.parse("2020-01-18T08:30"))
                .taskToDate(LocalDateTime.parse("2020-01-18T16:30"))
                .user(user2)
                .build());

        taskRepository.save(TaskEntity.builder()
                .taskName("task 8")
                .taskDesc("description waev rter we qwe tyrt asd ")
                .statusId(stausPlanned)
                .categoryId(catWork)
                .taskFromDate(LocalDateTime.parse("2020-01-19T10:30"))
                .taskToDate(LocalDateTime.parse("2020-01-19T11:00"))
                .user(user)
                .build());

        taskRepository.save(TaskEntity.builder()
                .taskName("task 9")
                .taskDesc("description ert hgf nbv sasdf gf")
                .statusId(stausProgress)
                .categoryId(catOther)
                .taskFromDate(LocalDateTime.parse("2020-01-21T19:45"))
                .taskToDate(LocalDateTime.parse("2020-01-21T21:30"))
                .user(user)
                .build());

        taskRepository.save(TaskEntity.builder()
                .taskName("task 10")
                .taskDesc("description 1eqw ada2v edw2 ")
                .statusId(stausProgress)
                .categoryId(catOther)
                .taskFromDate(LocalDateTime.parse("2020-01-19T09:30"))
                .taskToDate(LocalDateTime.parse("2020-01-19T10:30"))
                .user(user)
                .build());

        taskRepository.save(TaskEntity.builder()
                .taskName("task 11")
                .taskDesc("description 11")
                .statusId(stausCancelled)
                .categoryId(catHome)
                .taskFromDate(LocalDateTime.parse("2020-01-20T11:30"))
                .taskToDate(LocalDateTime.parse("2020-01-21T11:30"))
                .user(user2)
                .build());

    }



//            taskRepository.save(new TaskEntity(cat3, "name3", "description 3",
//                    status1, LocalDateTime.parse("2020-03-24T16:00"), LocalDateTime.parse("2020-03-24T17:00"), user2));
//            taskRepository.save(new TaskEntity(cat2, "name4", "description 4",
//                    status1, LocalDateTime.parse("2020-01-22T10:00"), LocalDateTime.parse("2020-01-22T16:00"), user2));
//            taskRepository.save(new TaskEntity(cat2, "name5", "description 5",
//                    status4, LocalDateTime.parse("2020-01-21T09:00"), LocalDateTime.parse("2020-01-23T16:00"), user2));
//            taskRepository.save(new TaskEntity(cat4, "name6", "description 6",
//                    status3, LocalDateTime.parse("2020-01-20T09:00"), LocalDateTime.parse("2020-01-20T13:30"), admin));
//            taskRepository.save(new TaskEntity(cat3, "name7", "description 77",
//                    status4, LocalDateTime.parse("2020-01-20T19:21"), LocalDateTime.parse("2020-01-20T21:21"), user1));
//            taskRepository.save(new TaskEntity(cat1, "name8", "description 222",
//                    status2, LocalDateTime.parse("2020-01-22T15:30"), LocalDateTime.parse("2020-01-23T16:30"), user2));
//            taskRepository.save(new TaskEntity(cat1, "name9", "description 309",
//                    status2, LocalDateTime.parse("2020-03-19T16:00"), LocalDateTime.parse("2020-03-24T17:00"), admin));
//            taskRepository.save(new TaskEntity(cat4, "name 10", "description 400",
//                    status2, LocalDateTime.parse("2020-01-21T11:00"), LocalDateTime.parse("2020-01-21T16:00"), admin));
//            taskRepository.save(new TaskEntity(cat2, "name 11", "description 511",
//                    status6, LocalDateTime.parse("2020-01-19T08:00"), LocalDateTime.parse("2020-01-20T21:00"), user2));
//            taskRepository.save(new TaskEntity(cat1, "name12", "description 632",
//                    status1, LocalDateTime.parse("2020-01-20T06:00"), LocalDateTime.parse("2020-01-20T12:30"), user2));


    @Override
    public void run(String... args) throws Exception {
        loadData();
    }
}