# JDK的不断更新导致hashmap的索引采用2分法思想发挥到极致，所以本deta cache的后序完善将放缓，新的任务本人将基于VPCS的Hall keeper 和运维更有效的交互进行深入研究，设计的研究项目如下。该项目的亮点为小到极致的跨平台高并发安全服务器。
新开一个用于缓存vpc部署 并集成了德塔数据库请求UTIL，
##### ![实例](http://progressed.io/bar/100?title=completed)已完善功能：缓存服务器的运行环境所有信息采集。 Mr.Luo
##### ![实例](http://progressed.io/bar/100?title=completed)已完善功能：采用java.lang进行缓存服务器运维管理，具体开源实例如下：
Mr.Zhongwei.Jian, https://blog.csdn.net/zhongweijian/article/details/7619383
##### ![实例](http://progressed.io/bar/100?title=completed)已完善功能：集成了德塔rest服务器做缓存业务。可springBoot（已经过滤但未删除，可还原） 和 detaBoot 2选1启动。 Mr.Luo
##### ![实例](http://progressed.io/bar/100?title=completed)已完善功能：REST请求。 Mr.Luo
##### ![实例](http://progressed.io/bar/100?title=completed)已完善功能：200 反馈。 Mr.Luo
##### ![实例](http://progressed.io/bar/100?title=completed)已完善功能：500 反馈。 Mr.Luo
##### ![实例](http://progressed.io/bar/100?title=completed)已完善功能：restMap。 Mr.Luo
##### ![实例](http://progressed.io/bar/100?title=completed)已完善功能：restForward。 Mr.Luo
##### ![实例](http://progressed.io/bar/100?title=completed)已完善功能：每秒1500并发控制。 Mr.Luo
##### ![实例](http://progressed.io/bar/100?title=completed)已完善功能：json 读写。 Mr.Luo
##### ![实例](http://progressed.io/bar/100?title=completed)已完善功能：时间设计。 Mr.Luo
##### ![实例](http://progressed.io/bar/100?title=completed)已完善功能：增加缓存超时更新机制。 Mr.Luo
##### ![实例](http://progressed.io/bar/100?title=completed)已完善功能：单机 10万 QPS。已测试。 Mr.Luo
##### ![实例](http://progressed.io/bar/100?title=completed)已完善功能：String to bit 2采用gzip进制快速压缩。 Mr.Luo

##### 正完善功能：key 和value 的最大长度。进行过滤。保证缓存功效，
 
##### ![实例](http://progressed.io/bar/70?title=completed)正完善功能：运维接口 服务器状态数据 定义   Mr.Lujun
##### ![实例](http://progressed.io/bar/80?title=completed)正完善功能：restPath=/getServerInfo 运维接口 结构   Mr.Lujun
##### 正完善功能：restPath=/getServerInfo 运维接口 研发   Mr.Chen

##### 未完善功能：proxy cache；
##### 未完善功能：map 分级序列化索引。
##### ![实例](http://progressed.io/bar/100?title=completed)已完善功能：准备全部剔除springboot。  
##### 未完善功能：引用VPCS skivvy 清理功能。
##### 未完善功能：hallkeeper admin页面 与运维交互
##### ![实例](http://progressed.io/bar/100?title=completed)已完善功能：配置的单例类
##### 未完善功能：编程规范引入sonar认证

##### 新任务：hallkeeper 系统日志分级管理。
##### 新任务：hallkeeper 系统日志分级反馈。
##### 新任务：离散的运维调试接口集合。
##### 新任务：可视化运维界面系统，admin 和desk app
##### 新任务：基于deta etl的 可重用的运维管理界面设计.
##### 新任务：运维流程进行可逆化离散操作。

#### 代码协作贡献者 （协作者按代码百分比享有项目各种合法权益与收益）即使以后文件删除了或不采用了， 这个百分比也不会减少和删除，视为终身受益。
鲁骏：1.1% 当前代码占比。日期20190304



