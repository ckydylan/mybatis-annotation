package com.niit.mybatisannotationdemo.mapper;

import com.niit.mybatisannotationdemo.model.Message;
import com.niit.mybatisannotationdemo.model.Page;
import com.niit.mybatisannotationdemo.param.MessageParam;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;


/**
 * @author : Lenovo
 * @date : 2020/4/7 10：19
 * @description :
 */
@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MessageMapperTest {

    @Autowired
    private  MessageMapper messageMapper;

    @Test
    @Order(1)
    public void testInsert(){
        //模拟数据
        Message message = Message.builder().msgText("樱花").msgSummary("春天").build();
        int num = messageMapper.insert(message);
        log.info("插入数据数：{}",num);
    }

    @Test
    @Order(2)
    public void  testSelectAll(){
        List<Message> messages = messageMapper.selectAll();
        if (messages == null){
            log.error("messages为null");
        }else {
            messages.forEach(message -> log.info("查询到的数据：{}",message));
        }
    }


    @Test
    @Order(3)
    public void testSelectById(){
        Message message = messageMapper.selectById(1);
        log.info("id为1的数据：{}",message);
    }

    @Test
    @Order(4)
    public void testDelete(){
        int num = messageMapper.delete(1);
        log.info("删除的数据数：{}",num);
    }

    @Test
    @Order(5)
    public void testUpdate(){
        Message message = Message.builder().msgId(1).msgText("computer").msgSummary("学校").build();
        int num = messageMapper.update(message);
        log.info("更新的数据条数：{}",num);
    }

    @Test
    @Order(6)
    public void testUpdateText(){
        Message message = Message.builder().msgId(1).msgText("hhh").msgSummary("").build();
        int num = messageMapper.updateText(message);
        log.info("更新Text的数据条数：{}",num);
    }


    @Test
    @Order(7)
    public void testBatchInsert(){
        List<Message> messages = new ArrayList<>(Arrays.asList(
                Message.builder().msgText("apple").msgSummary("水果").build(),
                Message.builder().msgText("orange").msgSummary("水果").build()));
        int num = messageMapper.batchInsert(messages);
        log.info("插入的数据条数：{}",num);
    }

    @Test
    @Order(8)
    public void testCount() {
        MessageParam messageParam = new MessageParam();
        messageParam.setMsgText("");
        messageParam.setMsgSummary("水果");
        long count = messageMapper.getCount(messageParam);
        log.info("count ---- , {}", count);
    }

    @Test
    @Order(9)
    public void testSelectByTextAndSummary() {
        Map<String, String> params = new HashMap<>();
        params.put("msgText", "apple");
        params.put("msgSummary", "院系");
        messageMapper.selectByTextAndSummary(params)
                .forEach(msg -> log.info(msg.toString()));
    }

    @Test
    @Order(10)
    public void testPage() {
        MessageParam messageParam = new MessageParam();
        messageParam.setMsgText("");
        messageParam.setMsgSummary("水果");
        messageParam.setCurrentPage(0);
        List<Message> msgs = messageMapper.selectMessages(messageParam);
        long count = messageMapper.getCount(messageParam);
        Page<Message> page = new Page<>(messageParam, count, msgs);
        log.info("page = {}", page);
    }
}