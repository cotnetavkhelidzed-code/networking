package org.example;

import java.util.ArrayList;
import java.util.List;

public class PupilRepository {
    List<Pupil> pupils = new ArrayList<>();

    List<Pupil> getAllpupils(){


        pupils.add(new Pupil("cotne",19,91));
        pupils.add(new Pupil("luka",21,98));
        pupils.add(new Pupil("erekle",21,34));

        return pupils;

    }

    public void addPupil(Pupil pupil){
        pupils.add(pupil);
    }


}
