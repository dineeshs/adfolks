FROM node:latest as builder
WORKDIR /UI
COPY . .
RUN npm install
RUN npm run build --prod


FROM nginx:alpine
COPY src/nginx/etc/conf.d/nginx.conf /etc/nginx/conf/nginx.conf
COPY --from=builder app/dist/UI user/share/nginx/html