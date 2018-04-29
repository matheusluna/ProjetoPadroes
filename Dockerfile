FROM tomcat
COPY target/BaberApp.war ${CATALINA_HOME}/webapps
