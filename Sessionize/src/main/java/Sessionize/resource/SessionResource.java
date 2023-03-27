package Sessionize.resource;


import Sessionize.entity.Session;
import Sessionize.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/session")
@RequiredArgsConstructor
public class SessionResource {
    private final SessionService sessionService;

    @PostMapping("/add")
    public Session addSession(@RequestBody Session session){
        return sessionService.addSession(session);
    }

    @GetMapping("{session_id}")
    public Session getSession(@PathVariable Long session_id){
        return sessionService.getOne(session_id);
    }

    @GetMapping("/")
    public List<Session> getSessions(){
        return sessionService.getAll();
    }

    @PutMapping("{session_id}")
    public Session updateSession(@PathVariable Long session_id, @RequestBody Session session){
        return sessionService.updateSession(session_id,session);
    }

    @DeleteMapping("{session_id}")
    public void deleteSession(@PathVariable Long session_id){
        sessionService.deleteSession(session_id);
    }
}
