FROM amazonlinux:2023



RUN yum update -y && yum install -y java-11-amazon-corretto



RUN yum update -y && yum install -y unzip wget



ARG CHROME_VERSION=83.0.4103.116
ARG CHROMEDRIVER_VERSION=83.0.4103.39



RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_x86_64.rpm
RUN yum install -y ./google-chrome-stable_current_x86_64.rpm



RUN yum install -y unzip
RUN wget -O /tmp/chromedriver.zip http://chromedriver.storage.googleapis.com/`curl -sS chromedriver.storage.googleapis.com/LATEST_RELEASE`/chromedriver_linux64.zip
RUN unzip /tmp/chromedriver.zip -d /usr/local/bin/



RUN yum install -y maven



VOLUME /reports



COPY ./ /app



WORKDIR /app



CMD ["mvn", "clean", "install"]