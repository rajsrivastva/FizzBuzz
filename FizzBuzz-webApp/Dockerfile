# Stage 1

FROM node:16-alpine as build-step

RUN mkdir -p /app

WORKDIR /app

COPY package.json /app

RUN npm install

COPY . /app

RUN npm run build --prod

# Stage 2

FROM nginx:1.21.4-alpine

COPY --from=build-step /app/dist/FizzBuzz-webApp /usr/share/nginx/html
#COPY nginx.site.template /etc/nginx/conf.d/
#COPY nginx.conf.template /etc/nginx/
#CMD envsubst '${BACKEND_URI}' < /etc/nginx/conf.d/nginx.site.template > /etc/nginx/conf.d/default.conf && exec nginx -g 'daemon off;'
#CMD envsubst '${BACKEND_URI}' < /etc/nginx/nginx.conf.template > /etc/nginx/nginx.conf && exec nginx -g 'daemon off;'