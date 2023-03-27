package Sessionize.service;

import Sessionize.entity.Session;

import java.util.List;

public interface SessionService {
    Session addSession(Session session);

    Session getOne(Long sessionId);

    List<Session> getAll();

    Session updateSession(Long sessionId, Session updatedSession);

    void deleteSession(Long sessionId);
}
