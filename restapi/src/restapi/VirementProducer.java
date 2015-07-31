package restapi;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;

public class VirementProducer {
	@Resource(mappedName = "queue/restbanko/virement")
	private Queue fileVirement;
	@Inject
	@JMSConnectionFactory("java:/ConnectionFactory")
	JMSContext context;

	public void sendMessage(Virement virement) {
		ObjectMessage objMsg = context.createObjectMessage();
		try {
			objMsg.setObject(virement);
			context.createProducer().send(fileVirement, objMsg);
		} catch (JMSException e) { // cas d'erreur }
		}
	}
}
