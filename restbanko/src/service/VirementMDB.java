package service;

import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.ejb.ActivationConfigProperty;

import model.Virement;

@MessageDriven(mappedName = "virementMDB", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/restbanko/virement"),
		@ActivationConfigProperty(propertyName = "ConnectionFactoryName", propertyValue = "java:/ConnectionFactory") })
public class VirementMDB implements MessageListener {
	@EJB private CompteService compteService;
	@Override
	public void onMessage(Message message) {
		try {
			Virement virement = message.getBody(Virement.class);
			compteService.creditage(virement.getIdcompteacrediter(), virement.getMontant());
			compteService.creditage(virement.getIdcompteadebiter(), -(virement.getMontant()));
			
		} catch (JMSException e) {
			// en cas d'erreur
		}
	}
}