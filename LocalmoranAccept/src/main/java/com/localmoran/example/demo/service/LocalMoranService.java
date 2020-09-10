package com.localmoran.example.demo.service;


public interface LocalMoranService {

    /**
     * 启动被邀请方
     *
     * @param input
     * @return
     */
    String startAccept(String id, String input, String roomId, String user);

    /**
     * 查询算法结果
     *
     * @param id
     * @return
     */
    String query(String id);
}