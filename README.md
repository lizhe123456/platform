# platform
嘿嘿
####功能需求
用户建表，至少要两张表，一张记录用户信息，用户注册的时候

1. 用户登录，然后可以到配置表单页，进行填写资料。
      填写资料：
            用户姓名：
            联系方式：      >> 这个单独存到一个表，留给我们自己，方便以后可以通知。搞个uid 为主键
            电子邮箱：
      
      填写系统配置资料：
           主机名(hostname):
           主机配置：  #这里电脑配置我会搞个复选框
           系统版本：
           ROOT密码：
           购买时长：
           所需端口号： #默认只能两个生效  22,80
            
            
            
我所想到的表内容


#ID  userid      systemloginname  systempassword  HostName    HDCapacity  CPUs   Disks  ApplyDate()   ExpireDate()    buy_money

 1     1           prohehaoyu           123456     hehaoyu      centos7.3    3     100G    20171215      20170115        100
























###############下面的以后再说 
           
2.用户控制台：（前端页面我来做）
     所需功能：
          电源管理：
          系统端口映射（公网IP地址，被映射公网端口...）
          
            
