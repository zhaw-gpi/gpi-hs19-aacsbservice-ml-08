package ch.zhaw.iwi.gpi.aacsb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JournalRepository
 */
public interface JournalRepository extends JpaRepository<JournalEntity, Long> {

    List<JournalEntity> findByJournalTitleIgnoreCase(String journalTitle);
}