# student-springboot-vue
使用前后端分离，基于springboot和vue的crud

## 开发阶段

前端项目在config/index.js 中设置代理 proxyTable ,以 `npm run dev` 启动前端项目

后端项目 直接启动

## 部署

### 方式一

前端项目执行构建 `npm run build` ，将 dist 目录下的文件拷贝至 后端项目的 resources/static 目录下

之后再打包后端项目，后端直接运行

### 方式二

通过 nginx ，配置静态文件访问路径，设置后端项目代理