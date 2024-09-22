## 本项目实现的最终作用是基于SSH实现一个在线旅游信息查询平台
## 分为2个角色
### 第1个角色为管理员角色，实现了如下功能：
 - 分类管理
 - 版块管理
 - 用户管理
 - 管理员登录
 - 网站介绍管理
 - 评价管理
### 第2个角色为用户角色，实现了如下功能：
 - 发布资源
 - 提交评论
 - 查看商品详情
 - 查看首页
 - 用户登录
## 数据库设计如下：
# 数据库设计文档

**数据库名：** ssh_zxtoursite

**文档版本：** 


| 表名                  | 说明       |
| :---: | :---: |
| [admin](#admin) | 管理员表 |
| [category](#category) | 分类表 |
| [comment](#comment) | 评价表 |
| [introduce](#introduce) |  |
| [news](#news) | 新闻资讯表 |
| [user](#user) | 用户表 |

**表名：** <a id="admin">admin</a>

**说明：** 管理员表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | adminname |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 管理员名称  |
|  3   | password |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 密码  |
|  4   | realname |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 真实名字  |
|  5   | type |   int   | 10 |   0    |    N     |  N   |       | 类型  |
|  6   | isDelete |   int   | 10 |   0    |    N     |  N   |       |   |
|  7   | category_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="category">category</a>

**说明：** 分类表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | cname |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 分类名称  |
|  3   | isDelete |   int   | 10 |   0    |    N     |  N   |       |   |

**表名：** <a id="comment">comment</a>

**说明：** 评价表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | content |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 内容  |
|  3   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  4   | isDelete |   int   | 10 |   0    |    N     |  N   |       |   |
|  5   | user_id |   int   | 10 |   0    |    Y     |  N   |   NULL    | 用户ID  |
|  6   | news_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  7   | category_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="introduce">introduce</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | addTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 添加时间  |
|  3   | content |   varchar   | 5000 |   0    |    Y     |  N   |   NULL    | 内容  |
|  4   | imageUrl |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 图片地址  |
|  5   | title |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 标题  |

**表名：** <a id="news">news</a>

**说明：** 新闻资讯表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | addTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 添加时间  |
|  3   | content |   varchar   | 5000 |   0    |    Y     |  N   |   NULL    | 内容  |
|  4   | imageUrl |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 图片地址  |
|  5   | status |   int   | 10 |   0    |    N     |  N   |       | 状态  |
|  6   | title |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 标题  |
|  7   | isDelete |   int   | 10 |   0    |    N     |  N   |       |   |
|  8   | category_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  9   | user_id |   int   | 10 |   0    |    Y     |  N   |   NULL    | 用户ID  |

**表名：** <a id="user">user</a>

**说明：** 用户表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 自增主键  |
|  2   | email |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 邮箱  |
|  3   | loginName |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | password |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 密码  |
|  5   | phone |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 电话  |
|  6   | realname |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 真实名字  |
|  7   | isDelete |   int   | 10 |   0    |    N     |  N   |       |   |

