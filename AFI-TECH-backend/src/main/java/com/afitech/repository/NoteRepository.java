package com.afitech.repository;

import com.afitech.modele.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByEtudiantId(Long etudiantId);
}
