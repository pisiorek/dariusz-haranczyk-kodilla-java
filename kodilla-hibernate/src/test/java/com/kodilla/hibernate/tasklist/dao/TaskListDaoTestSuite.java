package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Test
    public void testFindByListName() {
        //Given
        TaskList taskList = new TaskList("ToDo", "Works to do quick as possible");
        taskListDao.save(taskList);
        String listName = taskList.getListName();

        //When
        List<TaskList> readListNames =  taskListDao.findByListName(listName);

        //Then
        Assert.assertEquals(1, readListNames.size());

        //CleanUp
        int id = readListNames.get(0).getId();
        taskListDao.deleteById(id);


    }


}
