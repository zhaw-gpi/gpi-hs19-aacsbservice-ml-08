package ch.zhaw.iwi.gpi.aacsb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * AacsbRestController
 */
@RestController
public class AacsbRestController {

    @Autowired
    private JournalRepository journalRepository;

    @RequestMapping(value = "/aacsbapi/v1/journals/{journalTitle}", method = RequestMethod.GET)
    public ResponseEntity<JournalEntity> getJournal(@PathVariable String journalTitle){
        List<JournalEntity> journals = journalRepository.findByJournalTitleIgnoreCase(journalTitle);

        if(journals.size()==1){
            return new ResponseEntity<JournalEntity>(journals.get(0), HttpStatus.OK);
        } else if(journals.size() == 0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.MULTIPLE_CHOICES);
        }
    }
}