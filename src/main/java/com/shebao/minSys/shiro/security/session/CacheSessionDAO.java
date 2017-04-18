package com.shebao.minSys.shiro.security.session;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheSessionDAO extends EnterpriseCacheSessionDAO implements SessionDAO {
	private Logger logger = LoggerFactory.getLogger(getClass());
	 public CacheSessionDAO() {
	        super();
	    }

	@Override
	protected Serializable doCreate(Session session) {
		logger.info("");
		return super.doCreate(session);
	}

	@Override
	protected void doDelete(Session session) {
		// TODO Auto-generated method stub
		super.doDelete(session);
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		// TODO Auto-generated method stub
		return super.doReadSession(sessionId);
	}

	@Override
	protected void doUpdate(Session session) {
		// TODO Auto-generated method stub
		super.doUpdate(session);
	}

	@Override
	public Session readSession(Serializable sessionId) throws UnknownSessionException {
		// TODO Auto-generated method stub
		return super.readSession(sessionId);
	}

	@Override
	public Collection<Session> getActiveSessions() {
		// TODO Auto-generated method stub
		return super.getActiveSessions();
	}
	 

	 

}
