FROM java:8-jre

ENV WILDFLY_VERSION 8.2.0.Final
ENV WILDFLY_HOME /opt/wildfly

RUN cd $HOME && curl http://download.jboss.org/wildfly/$WILDFLY_VERSION/wildfly-$WILDFLY_VERSION.tar.gz | tar zx && mv $HOME/wildfly-$WILDFLY_VERSION $WILDFLY_HOME

# Add a mgmt-user for visualvm (user: wildfly / pw: wild4fly)
RUN echo 'wildfly=18237fe8dfe9e6c1e69c684c0f2d1eff' >> $WILDFLY_HOME/standalone/configuration/mgmt-users.properties

EXPOSE 8080
EXPOSE 9990

ADD target/jax-rs-performance.war /opt/wildfly/standalone/deployments/

CMD ["/opt/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]