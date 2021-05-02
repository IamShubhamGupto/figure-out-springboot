package first_maven_project.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("1","top1","desc1"),
			new Topic("3","top3","desc3"),
			new Topic("2","top2","desc2")
			));
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t ->t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
		
	}

	public void updateTopic(String id, Topic topic) {
		for(int i = 0; i < topics.size(); ++i) {
			if(topics.get(i).getId().equals(topic)) {
				topics.set(i, topic);
				return;
			}
		}
		
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
	
}
