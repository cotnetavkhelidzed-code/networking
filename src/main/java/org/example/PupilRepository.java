package org.example;

import java.util.ArrayList;
import java.util.List;

public class PupilRepository {
    List<Pupil> getAllpupils(){
        List<Pupil> pupils = new ArrayList<>();

        pupils.add(new Pupil("cotne tavkhelidze",19,91));
        pupils.add(new Pupil("luka burjanadze",21,98));
        pupils.add(new Pupil("erekle tavkhelidze",21,34));

        return pupils;
    }


}
