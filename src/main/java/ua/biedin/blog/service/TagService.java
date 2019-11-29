package ua.biedin.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.biedin.blog.entity.Tag;
import ua.biedin.blog.repository.TagRepo;

import java.util.List;

@Service
public class TagService {

    private final TagRepo tagRepo;

    @Autowired
    public TagService(TagRepo tagRepo) {
        this.tagRepo = tagRepo;
    }

    public List<Tag> getAllTags() {
        return tagRepo.findAll();
    }
}
