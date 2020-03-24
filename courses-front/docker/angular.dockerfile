# create image based on the official Node 13.2.0 image from dockerhub
FROM node:13.2.0

# install chrome for protractor tests
#RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
#RUN sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list'
#RUN apt-get update && apt-get install -yq google-chrome-stable

# Create a directory where our app will be placed
RUN mkdir -p /app

# set working directory where our commands run inside this new directory
WORKDIR /app

# add `/app/node_modules/.bin` to $PATH
ENV PATH /app/node_modules/.bin:$PATH

# copy the dependency definition
COPY package.json package-lock.json* /app/

# install and clean cache app dependencies (based on package.json file)
RUN npm install --no-optional && npm cache clean --force
RUN npm install -g @angular/cli

# get all the code needed to run the app
COPY . /app

# compile our application
#RUN npm run build

# expose the port the app runs in
EXPOSE 4200

# serve the app
CMD ng serve --host 0.0.0.0
