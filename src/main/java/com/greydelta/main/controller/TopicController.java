package com.greydelta.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.greydelta.main.model.Topic;
import com.greydelta.main.service.TopicService;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {		
		return topicService.getTopics();		
	}
	
	@RequestMapping("/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable String id) {		
		return topicService.getTopic(id);		
	}

	@RequestMapping(value="/topics", method=RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic) {		
		topicService.addTopic(topic);		
	}

	@RequestMapping(value="/topics/{id}", method=RequestMethod.PUT)
	public void updateTopic(@RequestBody Topic topic) {		
		topicService.updateTopic(topic);		
	}

	@RequestMapping(value="/topics/{id}", method=RequestMethod.DELETE)
	public void deleteTopic(@PathVariable String id) {		
		topicService.deleteTopic(id);		
	}

}
