package Sessionize.service.impl;

import Sessionize.entity.Session;
import Sessionize.entity.Status;
import Sessionize.repository.SessionRepository;
import Sessionize.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {
    private final SessionRepository sessionRepository;

    @Override
    public Session addSession(Session session) {
        session.setStatus(Status.PENDING);
        return sessionRepository.save(session);
    }

    @Override
    public Session getOne(Long sessionId ){
        return sessionRepository.getOne(sessionId);
    }
    @Override
    public List<Session> getAll() {
        return sessionRepository.findAll();
    }

    @Override
    public Session updateSession(Long sessionId, Session updatedSession) {
        Session sessionToUpdate = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new IllegalStateException("Session not found with id: " + sessionId));

        sessionToUpdate.setTitle(updatedSession.getTitle());
        sessionToUpdate.setDescription(updatedSession.getDescription());
        sessionToUpdate.setType(updatedSession.getType());
        sessionToUpdate.setLanguage(updatedSession.getLanguage());
        sessionToUpdate.setStatus(updatedSession.getStatus());
        sessionToUpdate.setSpeakerList(updatedSession.getSpeakerList());
        sessionToUpdate.setOrganizerList(updatedSession.getOrganizerList());

        return sessionRepository.save(sessionToUpdate);
    }

    @Override
    public void deleteSession(Long sessionId) {
        sessionRepository.deleteById(sessionId);
    }

}
