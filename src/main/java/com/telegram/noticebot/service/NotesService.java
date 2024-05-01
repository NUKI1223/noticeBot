package com.telegram.noticebot.service;

import com.telegram.noticebot.model.Notes;
import com.telegram.noticebot.repository.NotesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {
    private final NotesRepository notesRepository;

    public NotesService(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }
    public Notes saveNote(Notes note){
        return notesRepository.save(note);
    }
    public Notes updateNote(Notes note){
        return notesRepository.save(note);
    }
    public void deleteNote(Long id){
        notesRepository.deleteById(id);
    }
    public List<Notes> getNotes(){
        return notesRepository.findAll();
    }
    //TODO: надо сделать метод, который отслеживает дату и когда дата окончания наступает, заметки удаляются, а еще скорее всего нужно как то настроить ID, чтобы оно всегда начиналось с 1 и обновлялось

}
