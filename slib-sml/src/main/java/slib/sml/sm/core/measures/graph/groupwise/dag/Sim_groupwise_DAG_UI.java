/*

 Copyright or © or Copr. Ecole des Mines d'Alès (2012) 

 This software is a computer program whose purpose is to 
 process semantic graphs.

 This software is governed by the CeCILL  license under French law and
 abiding by the rules of distribution of free software.  You can  use, 
 modify and/ or redistribute the software under the terms of the CeCILL
 license as circulated by CEA, CNRS and INRIA at the following URL
 "http://www.cecill.info". 

 As a counterpart to the access to the source code and  rights to copy,
 modify and redistribute granted by the license, users are provided only
 with a limited warranty  and the software's author,  the holder of the
 economic rights,  and the successive licensors  have only  limited
 liability. 

 In this respect, the user's attention is drawn to the risks associated
 with loading,  using,  modifying and/or developing or reproducing the
 software by the user in light of its specific status of free software,
 that may mean  that it is complicated to manipulate,  and  that  also
 therefore means  that it is reserved for developers  and  experienced
 professionals having in-depth computer knowledge. Users are therefore
 encouraged to load and test the software's suitability as regards their
 requirements in conditions enabling the security of their systems and/or 
 data to be ensured and,  more generally, to use and operate it in the 
 same conditions as regards security. 

 The fact that you are presently reading this means that you have had
 knowledge of the CeCILL license and that you accept its terms.

 */
package slib.sml.sm.core.measures.graph.groupwise.dag;

import java.util.Set;
import org.openrdf.model.URI;

import slib.sml.sm.core.engine.SM_Engine;
import slib.sml.sm.core.utils.SMconf;
import slib.utils.impl.SetUtils;

/**
 * Gentleman R: Visualizing and distances using GO. Retrieved Jan. 10th 2007.
 * http://www.bioconductor.org/packages/release/bioc/vignettes/GOstats/inst/doc/GOvis.pdf
 *
 * @author Sébastien Harispe
 *
 */
public class Sim_groupwise_DAG_UI extends Sim_groupwise_DAG_abstract {

    
    @Override
    public double sim(Set<URI> setA, Set<URI> setB, SM_Engine rc, SMconf conf) {

        Set<URI> anc_setA = rc.getAncestorsInc(setA);
        Set<URI> anc_setB = rc.getAncestorsInc(setB);

        Set<URI> intersection = SetUtils.intersection(anc_setA, anc_setB);
        Set<URI> union = SetUtils.union(anc_setA, anc_setB);

        return (double) intersection.size() / union.size();
    }
}