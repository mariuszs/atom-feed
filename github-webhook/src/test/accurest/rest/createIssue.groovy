package rest

io.codearte.accurest.dsl.GroovyDsl.make {
	request {
		method 'POST'
		url '/'
		body '''
{
  "action": "created",
  "issue": {
    "url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/issues/559",
    "repository_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix",
    "labels_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/issues/559/labels{/name}",
    "comments_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/issues/559/comments",
    "events_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/issues/559/events",
    "html_url": "https://github.com/spring-cloud/spring-cloud-netflix/issues/559",
    "id": 108688072,
    "number": 559,
    "title": "DiscoveryClient content seems null",
    "user": {
      "login": "elerion",
      "id": 14874472,
      "avatar_url": "https://avatars.githubusercontent.com/u/14874472?v=3",
      "gravatar_id": "",
      "url": "https://api.github.com/users/elerion",
      "html_url": "https://github.com/elerion",
      "followers_url": "https://api.github.com/users/elerion/followers",
      "following_url": "https://api.github.com/users/elerion/following{/other_user}",
      "gists_url": "https://api.github.com/users/elerion/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/elerion/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/elerion/subscriptions",
      "organizations_url": "https://api.github.com/users/elerion/orgs",
      "repos_url": "https://api.github.com/users/elerion/repos",
      "events_url": "https://api.github.com/users/elerion/events{/privacy}",
      "received_events_url": "https://api.github.com/users/elerion/received_events",
      "type": "User",
      "site_admin": false
    },
    "labels": [
      {
        "url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/labels/question",
        "name": "question",
        "color": "cc317c"
      }
    ],
    "state": "closed",
    "locked": false,
    "assignee": null,
    "milestone": null,
    "comments": 14,
    "created_at": "2015-09-28T15:51:07Z",
    "updated_at": "2016-04-13T21:46:21Z",
    "closed_at": "2015-09-30T10:32:10Z",
    "body": "Hi,\\r\\n\\r\\nI use SNAPSHOT version add when i try to autowired the discoveryClient the content is null, my service is registered to eurekaServer.\\r\\n\\r\\nI haven't this problem with the milestones (M1) version\\r\\n\\r\\n```java\\r\\n@Component\\r\\npublic class EurekaClients {\\r\\n\\r\\n\\t@Autowired\\r\\n\\t@Lazy\\r\\n\\tprivate DiscoveryClient discoveryClient;\\r\\n\\r\\n\\t@Autowired\\r\\n\\tprivate SwaggerConfig swaggerConfig;\\r\\n\\r\\n\\tpublic HashMap<String, String> getAllClients() {\\r\\n\\t\\tHashMap<String, String> urlClients = new HashMap<String, String>();\\r\\n\\t\\tdiscoveryClient.getApplications().getRegisteredApplications().forEach(a -> {\\r\\n\\t\\t\\ta.getInstances().forEach(i -> {\\r\\n\\t\\t\\t\\turlClients.put(i.getAppName(),\\r\\n\\t\\t\\t\\t\\t\\tswaggerConfig.getPath() + i.getHomePageUrl().toString() + swaggerConfig.getPattern());\\r\\n\\t\\t\\t});\\r\\n\\t\\t});\\r\\n\\t\\treturn urlClients;\\r\\n\\t}\\r\\n\\r\\n}\\r\\n```\\r\\n\\r\\nI have this exception : \\r\\n\\r\\n```\\r\\norg.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type [com.netflix.discovery.DiscoveryClient] found for dependency: expected at least 1 bean which qualifies as autowire candidate for this dependency. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true), @org.springframework.context.annotation.Lazy(value=true)}\\r\\n\\tat org.springframework.beans.factory.support.DefaultListableBeanFactory.raiseNoSuchBeanDefinitionException(DefaultListableBeanFactory.java:1326) ~[spring-beans-4.2.1.RELEASE.jar:4.2.1.RELEASE]\\r\\n\\tat org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1072) ~[spring-beans-4.2.1.RELEASE.jar:4.2.1.RELEASE]\\r\\n\\tat org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver$1.getTarget(ContextAnnotationAutowireCandidateResolver.java:82) ~[spring-context-4.2.1.RELEASE.jar:4.2.1.RELEASE]\\r\\n\\tat org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.getTarget(CglibAopProxy.java:685) ~[spring-aop-4.2.1.RELEASE.jar:4.2.1.RELEASE]\\r\\n\\tat org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:636) ~[spring-aop-4.2.1.RELEASE.jar:4.2.1.RELEASE]\\r\\n\\tat com.netflix.discovery.DiscoveryClient$$EnhancerBySpringCGLIB$$68978133.getApplications(<generated>) ~[spring-core-4.2.1.RELEASE.jar:1.2.5]\\r\\n\\tat com.wl.protys.tools.swagger.EurekaClients.getAllClients(EurekaClients.java:28) ~[classes/:na]\\r\\n\\tat com.wl.protys.tools.swagger.IndexController.index(IndexController.java:16) ~[classes/:na]\\r\\n\\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_11]\\r\\n\\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_11]\\r\\n\\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_11]\\r\\n\\tat java.lang.reflect.Method.invoke(Method.java:483) ~[na:1.8.0_11]\\r\\n\\tat org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:221) ~[spring-web-4.2.1.RELEASE.jar:4.2.1.RELEASE]\\r\\n\\tat org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:137) ~[spring-web-4.2.1.RELEASE.jar:4.2.1.RELEASE]\\r\\n\\tat org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:111) ~[spring-webmvc-4.2.1.RELEASE.jar:4.2.1.RELEASE]\\r\\n\\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:806) ~[spring-webmvc-4.2.1.RELEASE.jar:4.2.1.RELEASE]\\r\\n\\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:729) ~[spring-webmvc-4.2.1.RELEASE.jar:4.2.1.RELEASE]\\r\\n\\tat org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:85) ~[spring-webmvc-4.2.1.RELEASE.jar:4.2.1.RELEASE]\\r\\n\\tat org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:959) ~[spring-webmvc-4.2.1.RELEASE.jar:4.2.1.RELEASE]\\r\\n\\tat org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:893) ~[spring-webmvc-4.2.1.RELEASE.jar:4.2.1.RELEASE]\\r\\n\\tat org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:970) ~[spring-webmvc-4.2.1.RELEASE.jar:4.2.1.RELEASE]\\r\\n\\tat org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:861) ~[spring-webmvc-4.2.1.RELEASE.jar:4.2.1.RELEASE]\\r\\n\\tat javax.servlet.http.HttpServlet.service(HttpServlet.java:622) ~[tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:846) ~[spring-webmvc-4.2.1.RELEASE.jar:4.2.1.RELEASE]\\r\\n\\tat javax.servlet.http.HttpServlet.service(HttpServlet.java:729) ~[tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:291) ~[tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:206) ~[tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52) ~[tomcat-embed-websocket-8.0.26.jar:8.0.26]\\r\\n\\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:239) ~[tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:206) ~[tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat org.springframework.boot.actuate.autoconfigure.EndpointWebMvcAutoConfiguration$ApplicationContextHeaderFilter.doFilterInternal(EndpointWebMvcAutoConfiguration.java:249) ~[spring-boot-actuator-1.3.0.M5.jar:1.3.0.M5]\\r\\n\\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) ~[spring-web-4.2.1.RELEASE.jar:4.2.1.RELEASE]\\r\\n\\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:239) ~[tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:206) ~[tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat org.springframework.boot.actuate.trace.WebRequestTraceFilter.doFilterInternal(WebRequestTraceFilter.java:102) ~[spring-boot-actuator-1.3.0.M5.jar:1.3.0.M5]\\r\\n\\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) ~[spring-web-4.2.1.RELEASE.jar:4.2.1.RELEASE]\\r\\n\\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:239) ~[tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:206) ~[tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:85) ~[spring-web-4.2.1.RELEASE.jar:4.2.1.RELEASE]\\r\\n\\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) ~[spring-web-4.2.1.RELEASE.jar:4.2.1.RELEASE]\\r\\n\\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:239) ~[tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:206) ~[tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat org.springframework.web.filter.HttpPutFormContentFilter.doFilterInternal(HttpPutFormContentFilter.java:87) ~[spring-web-4.2.1.RELEASE.jar:4.2.1.RELEASE]\\r\\n\\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) ~[spring-web-4.2.1.RELEASE.jar:4.2.1.RELEASE]\\r\\n\\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:239) ~[tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:206) ~[tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat org.springframework.web.filter.HiddenHttpMethodFilter.doFilterInternal(HiddenHttpMethodFilter.java:77) ~[spring-web-4.2.1.RELEASE.jar:4.2.1.RELEASE]\\r\\n\\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) ~[spring-web-4.2.1.RELEASE.jar:4.2.1.RELEASE]\\r\\n\\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:239) ~[tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:206) ~[tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat org.springframework.boot.actuate.autoconfigure.MetricsFilter.doFilterInternal(MetricsFilter.java:69) ~[spring-boot-actuator-1.3.0.M5.jar:1.3.0.M5]\\r\\n\\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:107) ~[spring-web-4.2.1.RELEASE.jar:4.2.1.RELEASE]\\r\\n\\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:239) ~[tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:206) ~[tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:219) ~[tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:106) [tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:502) [tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:142) [tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:79) [tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:88) [tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:518) [tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1091) [tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:673) [tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1526) [tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.run(NioEndpoint.java:1482) [tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142) [na:1.8.0_11]\\r\\n\\tat java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617) [na:1.8.0_11]\\r\\n\\tat org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) [tomcat-embed-core-8.0.26.jar:8.0.26]\\r\\n\\tat java.lang.Thread.run(Thread.java:745) [na:1.8.0_11]\\r\\n```\\r\\n\\r\\nAnd this is the content of my discoveryClient variable\\r\\n![erreureureka](https://cloud.githubusercontent.com/assets/14874472/10140683/0eadc780-6609-11e5-990a-628cfa806e38.PNG)\\r\\n"
  },
  "comment": {
    "url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/issues/comments/209662068",
    "html_url": "https://github.com/spring-cloud/spring-cloud-netflix/issues/559#issuecomment-209662068",
    "issue_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/issues/559",
    "id": 209662068,
    "user": {
      "login": "smithapitla",
      "id": 3036820,
      "avatar_url": "https://avatars.githubusercontent.com/u/3036820?v=3",
      "gravatar_id": "",
      "url": "https://api.github.com/users/smithapitla",
      "html_url": "https://github.com/smithapitla",
      "followers_url": "https://api.github.com/users/smithapitla/followers",
      "following_url": "https://api.github.com/users/smithapitla/following{/other_user}",
      "gists_url": "https://api.github.com/users/smithapitla/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/smithapitla/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/smithapitla/subscriptions",
      "organizations_url": "https://api.github.com/users/smithapitla/orgs",
      "repos_url": "https://api.github.com/users/smithapitla/repos",
      "events_url": "https://api.github.com/users/smithapitla/events{/privacy}",
      "received_events_url": "https://api.github.com/users/smithapitla/received_events",
      "type": "User",
      "site_admin": false
    },
    "created_at": "2016-04-13T21:46:21Z",
    "updated_at": "2016-04-13T21:46:21Z",
    "body": "@dsyer \\r\\nList<ServiceInstance> list = client.getInstances(service) returns empty list even though I see the services as running in eureka. I tried using EurekaClient, DiscoveryClient and EurekaDiscoveryClient. But no luck there :( any idea what could be wrong. "
  },
  "repository": {
    "id": 21741891,
    "name": "spring-cloud-netflix",
    "full_name": "spring-cloud/spring-cloud-netflix",
    "owner": {
      "login": "spring-cloud",
      "id": 7815877,
      "avatar_url": "https://avatars.githubusercontent.com/u/7815877?v=3",
      "gravatar_id": "",
      "url": "https://api.github.com/users/spring-cloud",
      "html_url": "https://github.com/spring-cloud",
      "followers_url": "https://api.github.com/users/spring-cloud/followers",
      "following_url": "https://api.github.com/users/spring-cloud/following{/other_user}",
      "gists_url": "https://api.github.com/users/spring-cloud/gists{/gist_id}",
      "starred_url": "https://api.github.com/users/spring-cloud/starred{/owner}{/repo}",
      "subscriptions_url": "https://api.github.com/users/spring-cloud/subscriptions",
      "organizations_url": "https://api.github.com/users/spring-cloud/orgs",
      "repos_url": "https://api.github.com/users/spring-cloud/repos",
      "events_url": "https://api.github.com/users/spring-cloud/events{/privacy}",
      "received_events_url": "https://api.github.com/users/spring-cloud/received_events",
      "type": "Organization",
      "site_admin": false
    },
    "private": false,
    "html_url": "https://github.com/spring-cloud/spring-cloud-netflix",
    "description": "Integration with Netflix OSS components",
    "fork": false,
    "url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix",
    "forks_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/forks",
    "keys_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/keys{/key_id}",
    "collaborators_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/collaborators{/collaborator}",
    "teams_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/teams",
    "hooks_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/hooks",
    "issue_events_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/issues/events{/number}",
    "events_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/events",
    "assignees_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/assignees{/user}",
    "branches_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/branches{/branch}",
    "tags_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/tags",
    "blobs_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/git/blobs{/sha}",
    "git_tags_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/git/tags{/sha}",
    "git_refs_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/git/refs{/sha}",
    "trees_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/git/trees{/sha}",
    "statuses_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/statuses/{sha}",
    "languages_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/languages",
    "stargazers_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/stargazers",
    "contributors_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/contributors",
    "subscribers_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/subscribers",
    "subscription_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/subscription",
    "commits_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/commits{/sha}",
    "git_commits_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/git/commits{/sha}",
    "comments_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/comments{/number}",
    "issue_comment_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/issues/comments{/number}",
    "contents_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/contents/{+path}",
    "compare_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/compare/{base}...{head}",
    "merges_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/merges",
    "archive_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/{archive_format}{/ref}",
    "downloads_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/downloads",
    "issues_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/issues{/number}",
    "pulls_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/pulls{/number}",
    "milestones_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/milestones{/number}",
    "notifications_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/notifications{?since,all,participating}",
    "labels_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/labels{/name}",
    "releases_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/releases{/id}",
    "deployments_url": "https://api.github.com/repos/spring-cloud/spring-cloud-netflix/deployments",
    "created_at": "2014-07-11T15:46:12Z",
    "updated_at": "2016-04-13T16:34:23Z",
    "pushed_at": "2016-04-13T04:00:13Z",
    "git_url": "git://github.com/spring-cloud/spring-cloud-netflix.git",
    "ssh_url": "git@github.com:spring-cloud/spring-cloud-netflix.git",
    "clone_url": "https://github.com/spring-cloud/spring-cloud-netflix.git",
    "svn_url": "https://github.com/spring-cloud/spring-cloud-netflix",
    "homepage": "http://cloud.spring.io/spring-cloud-netflix/",
    "size": 6756,
    "stargazers_count": 333,
    "watchers_count": 333,
    "language": "Java",
    "has_issues": true,
    "has_downloads": true,
    "has_wiki": true,
    "has_pages": true,
    "forks_count": 209,
    "mirror_url": null,
    "open_issues_count": 136,
    "forks": 209,
    "open_issues": 136,
    "watchers": 333,
    "default_branch": "master"
  },
  "organization": {
    "login": "spring-cloud",
    "id": 7815877,
    "url": "https://api.github.com/orgs/spring-cloud",
    "repos_url": "https://api.github.com/orgs/spring-cloud/repos",
    "events_url": "https://api.github.com/orgs/spring-cloud/events",
    "hooks_url": "https://api.github.com/orgs/spring-cloud/hooks",
    "issues_url": "https://api.github.com/orgs/spring-cloud/issues",
    "members_url": "https://api.github.com/orgs/spring-cloud/members{/member}",
    "public_members_url": "https://api.github.com/orgs/spring-cloud/public_members{/member}",
    "avatar_url": "https://avatars.githubusercontent.com/u/7815877?v=3",
    "description": "Tools for building common patterns in distributed systems with Spring"
  },
  "sender": {
    "login": "smithapitla",
    "id": 3036820,
    "avatar_url": "https://avatars.githubusercontent.com/u/3036820?v=3",
    "gravatar_id": "",
    "url": "https://api.github.com/users/smithapitla",
    "html_url": "https://github.com/smithapitla",
    "followers_url": "https://api.github.com/users/smithapitla/followers",
    "following_url": "https://api.github.com/users/smithapitla/following{/other_user}",
    "gists_url": "https://api.github.com/users/smithapitla/gists{/gist_id}",
    "starred_url": "https://api.github.com/users/smithapitla/starred{/owner}{/repo}",
    "subscriptions_url": "https://api.github.com/users/smithapitla/subscriptions",
    "organizations_url": "https://api.github.com/users/smithapitla/orgs",
    "repos_url": "https://api.github.com/users/smithapitla/repos",
    "events_url": "https://api.github.com/users/smithapitla/events{/privacy}",
    "received_events_url": "https://api.github.com/users/smithapitla/received_events",
    "type": "User",
    "site_admin": false
  }
}
'''
	}
	response {
		status 200
	}
}