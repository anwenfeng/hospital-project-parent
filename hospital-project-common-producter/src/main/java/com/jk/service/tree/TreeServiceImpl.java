package com.jk.service.tree;

import com.jk.dao.tree.TreeMapper;
import com.jk.pojo.tree.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("treeService")
public class TreeServiceImpl implements TreeService {

    @Autowired
    private TreeMapper treeMapper;

    @Override
    public List<Tree> queryTreeList(int i) {
        List<Tree> parentList=treeMapper.queryTreeList(i);

        if (parentList!=null&&parentList.size()>0) {

            for (int j = 0; j < parentList.size(); j++) {

                List<Tree> childList=treeMapper.queryTreeList(parentList.get(j).getId());

                if (childList!=null&&childList.size()>0) {

                    parentList.get(j).setNodes(childList);

                    for (int k = 0; k < childList.size(); k++) {

                        List<Tree> childChildList=queryTreeList(childList.get(k).getId());

                        if (childChildList!=null && childChildList.size()>0) {

                            childList.get(k).setNodes(childChildList);

                        }
                    }

                }
            }
        }


        return parentList;
    }
}
