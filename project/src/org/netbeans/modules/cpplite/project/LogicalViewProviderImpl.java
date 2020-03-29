/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.cpplite.project;

import java.awt.Image;
import org.netbeans.spi.project.ui.LogicalViewProvider;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataObjectNotFoundException;
import org.openide.nodes.FilterNode;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;

/**
 *
 * @author lahvac
 */
public class LogicalViewProviderImpl implements LogicalViewProvider {

    private final CPPLiteProject prj;

    public LogicalViewProviderImpl(CPPLiteProject prj) {
        this.prj = prj;
    }
    
    @Override
    public Node createLogicalView() {
        try {
            return new RootNode(DataObject.find(prj.getProjectDirectory()).getNodeDelegate());
        } catch (DataObjectNotFoundException ex) {
            return Node.EMPTY;
        }
    }

    @Override
    public Node findPath(Node root, Object target) {
        return null; //XXX
    }

    private static class RootNode extends FilterNode {

        public RootNode(Node delegate) {
            super(delegate);
        }

        @Override
        public Image getIcon(int type) {
            return ImageUtilities.loadImage("org/netbeans/modules/cpplite/project/resources/project.gif");
        }

        @Override
        public Image getOpenedIcon(int type) {
            return ImageUtilities.loadImage("org/netbeans/modules/cpplite/project/resources/projectOpen.gif");
        }
        
    }
}
