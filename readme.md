[TOC]

SOR (system of record) of image audit system.

# /images
## post: 存储一个 image
1. 201 and save

# /images/{iid}/approval
## post: 存储验证通过的 image 列表
1. 201 and save

# /images
## get: 获取验证通过的 image 列表
1. 200 and get
2. paging

# /images/iid
## get: 获取 image 详情
1. 200 and get
2. 404