package com.barton.model;

import com.barton.utils.mainUtils;
import lombok.Data;

import java.util.*;

/**
 * NeverNote Created by Majisto on 8/26/2018.
 */
@Data
public class NoteBook {
    private String name;
    private String tag;
    private Map<String, Map<String, Note>> tagMap = new HashMap<>();
    private Set<String> noteTitleSet = new HashSet<>(); //Tells us if note is in notes List.  Prevents duplicate notes based on title.

    public void addNote(Note note){
        if(noteTitleSet.add(note.getTitle())){
            for (String s : note.getTags()) {
                if (tagMap.containsKey(s)){ //Already in map, add it to list
                    Map<String, Note> innerMap = tagMap.get(s);
                    innerMap.put(note.getTitle(), note);
                } else { //Need to add new key and list
                    Map<String, Note> innerMap = new HashMap<>();
                    innerMap.put(note.getTitle(), note);
                    tagMap.put(s, innerMap);
                }
            }
        }
        else { //Update existing note
            updateNote(note);
        }
    }

    public List<Note> getNotesForTag(String tag){
        return new ArrayList<>(tagMap.get(tag).values());
    }

    public void deleteNoteByTitle(String title){
        if (noteTitleSet.remove(title)){ //successful removal means it was in the set.
            tagMap.values().forEach(e -> e.remove(title));
        }
    }

    public NoteBook(String name){
        this.name = name;
    }

    private void updateNote(Note note){
        note.setLastModified(mainUtils.generateTimeStamp());
        for (String tag : note.getTags()){
            if (!tagMap.containsKey(tag)){ //No key means a new tag we need to add
                Map<String, Note> innerMap = new HashMap<>();
                innerMap.put(note.getTitle(), note);
                tagMap.put(tag, innerMap);
            } else {
                tagMap.get(tag).put(note.getTitle(), note);
            }
        }
    }
}
