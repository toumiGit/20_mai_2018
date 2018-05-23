package de.wagawin.factory;

import de.wagawin.repository.ChildInfoViewRepository;
import de.wagawin.view.ChildInfo;
import de.wagawin.view.ChildInfoView;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildInfoFactory {

    @Autowired
    ChildInfoViewRepository viewRepository;


    public ChildInfo getChildInfo(int childId){
        ChildInfoView view = viewRepository.getById(childId);
        Validate.notNull(view, "view must be not null");
        return new ChildInfo(view);
    }
}
